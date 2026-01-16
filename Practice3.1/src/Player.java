public class Player {
    public static void main(String[] args) {

        // Добавление треков
        MusicPlaylist.addSong("OMFG - HELLO");
        MusicPlaylist.addSong("SKRILLEX - MONSTER");
        MusicPlaylist.addSong("MAROON5 - GIRLS LIKE YOU");
        MusicPlaylist.addSong("MARTIN GARIX - ANIMALS");
        MusicPlaylist.addSong("DJ ANTONIO - AUTOBAN");

        //Вывод информации
        MusicPlaylist.print();

        //Перемешка музыки
        MusicPlaylist.shuffle();
        MusicPlaylist.print();

        //Перемещение музыки
        MusicPlaylist.moveSong(0,4);
        MusicPlaylist.print();

        //Удаление музыки
        MusicPlaylist.removeSong(0);
        MusicPlaylist.print();

    }
}