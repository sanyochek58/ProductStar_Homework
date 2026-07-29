import java.util.List;

public interface RankingSystemService {
    void addPlayer(Player player);
    void updatePlayerRating(int playerId, int newRating);
    List<Player> getTopPlayers(int n);
    int getPlayerRank(int playerId);
}
