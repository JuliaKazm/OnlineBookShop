package patterns;

import java.util.logging.*;

public class BooksFactory {
    private static final Logger logger = Logger.getLogger(BooksFactory.class.getName());

    public interface Book {
        void display();
    }

    public static class Romance implements Book {
        @Override
        public void display() {
            logger.log(Level.INFO, "Displaying a romance book.");
        }
    }

    public static class Mystery implements Book {
        @Override
        public void display() {
            logger.log(Level.INFO, "Displaying a mystery book.");
        }
    }

    public static class Fiction implements Book {
        @Override
        public void display() {
            logger.log(Level.INFO, "Displaying a fiction book.");
        }
    }

    public interface BookFactory {
        Book createBook();
    }

    public static class RomanceFactory implements BookFactory {
        @Override
        public Book createBook() {
            return new Romance();
        }
    }

    public static class MysteryFactory implements BookFactory {
        @Override
        public Book createBook() {
            return new Mystery();
        }
    }

    public static class FictionFactory implements BookFactory {
        @Override
        public Book createBook() {
            return new Fiction();
        }
    }

    public static void main(String[] args) {
        Logger.getLogger("").setLevel(Level.ALL);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);

        BookFactory bookFactory = new RomanceFactory();
        Book romanceBook = bookFactory.createBook();
        romanceBook.display();

        bookFactory = new MysteryFactory();
        Book mysteryBook = bookFactory.createBook();
        mysteryBook.display();

        bookFactory = new FictionFactory();
        Book fictionBook = bookFactory.createBook();
        fictionBook.display();
    }
}



