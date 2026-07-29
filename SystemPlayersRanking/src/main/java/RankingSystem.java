import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class RankingSystem implements RankingSystemService{

    private TreeMap<Integer, Set<Player>> playerRankings = new TreeMap<>();

    public TreeMap<Integer, Set<Player>> getPlayerRankings() {
        return playerRankings;
    }

    public void setPlayerRankings(TreeMap<Integer, Set<Player>> playerRankings) {
        this.playerRankings = playerRankings;
    }


    @Override
    public void addPlayer(Player player) {
        Set<Player> players = playerRankings.getOrDefault(player.getRating(), new HashSet<>());
        players.add(player);
        playerRankings.put(player.getRating(), players);
    }

    @Override
    public void updatePlayerRating(int playerId, int newRating) {
        Player player = findPlayerById(playerId);

        Set<Player> oldRatingGroup = playerRankings.get(player.getRating());
        oldRatingGroup.remove(player);
        if (oldRatingGroup.isEmpty()) {
            playerRankings.remove(player.getRating());
        }

        player.setRating(newRating);
        playerRankings.computeIfAbsent(newRating, rating -> new HashSet<>()).add(player);
    }

    @Override
    public List<Player> getTopPlayers(int n) {
        int totalPlayers = playerRankings.values().stream().mapToInt(Set::size).sum();
        if (n <= 0 || n > totalPlayers) {
            throw new IllegalArgumentException(
                    "Некорректное количество игроков: " + n + ". Всего игроков в системе: " + totalPlayers);
        }

        List<Player> topPlayers = new ArrayList<>();
        for (Set<Player> playersWithSameRating : playerRankings.descendingMap().values()) {
            for (Player player : playersWithSameRating) {
                topPlayers.add(player);
                if (topPlayers.size() == n) {
                    return topPlayers;
                }
            }
        }
        return topPlayers;
    }

    @Override
    public int getPlayerRank(int playerId) {
        Player target = findPlayerById(playerId);

        int rank = 1;
        for (Set<Player> playersWithSameRating : playerRankings.descendingMap().values()) {
            if (playersWithSameRating.contains(target)) {
                return rank;
            }
            rank += playersWithSameRating.size();
        }
        throw new PlayerNotFoundException("Игрок с ID " + playerId + " не найден в системе");
    }

    private Player findPlayerById(int playerId) {
        for (Set<Player> players : playerRankings.values()) {
            for (Player player : players) {
                if (player.getId() == playerId) {
                    return player;
                }
            }
        }
        throw new PlayerNotFoundException("Игрок с ID " + playerId + " не найден в системе");
    }
}
