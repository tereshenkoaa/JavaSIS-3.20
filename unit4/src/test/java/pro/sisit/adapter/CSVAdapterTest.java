package pro.sisit.adapter;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pro.sisit.adapter.impl.CSVAdapter;
import pro.sisit.model.Author;
import pro.sisit.model.Book;

// TODO: 2. Описать тестовые кейсы

public class CSVAdapterTest {

    private String currentDir;

    @Before
    public void createFile() throws IOException {

        currentDir = new File("").getAbsolutePath().toString();

        // TODO: создать и заполнить csv-файл для сущности Author
        File fileAutors = new File(Paths.get(currentDir,"test-author-file.csv").toString());
        fileAutors.createNewFile();
        // TODO: создать и заполнить csv-файл для сущности Book

        File fileBooks = new File(Paths.get(currentDir,"test-book-file.csv").toString());
        fileBooks.createNewFile();

        // * По желанию можете придумать и свои сущности
    }

    @After
    public void deleteFile() {
        // TODO: удалить файлы после тестирования
        new File(Paths.get(currentDir,"test-author-file.csv").toString()).delete();
        new File(Paths.get(currentDir,"test-book-file.csv").toString()).delete();
    }

    @Test
    public void testRead() throws IOException {

        String bookFilePath = Paths.get(currentDir,"test-book-file.csv").toString();
        String bookAuthorPath = Paths.get(currentDir,"test-author-file.csv").toString();

        CSVAdapter<Book> bookCsvAdapter =
                new CSVAdapter(Book.class, bookFilePath);

        Book bookAppend = new Book(
                "Будущее",
                "Глуховский",
                "Научная фантастика",
                "978-5-17-118366-0");

        bookCsvAdapter.append(bookAppend);


        Book book1 = (Book) bookCsvAdapter.read(1);
        assertEquals("Глуховский", book1.getAuthor());
        assertEquals("Будущее", book1.getName());
        assertEquals("978-5-17-118366-0", book1.getIsbn());
        assertEquals("Научная фантастика", book1.getGenre());

//        Book expectedBook0 = new Book(
//                "Убик",
//                "Филип Дик",
//                "Научная фантастика",
//                "978-5-699-97309-5");
//
//        Book actualBook0 = (Book) bookCsvAdapter.read(1);
//        assertEquals(expectedBook0, actualBook0);

        // TODO: написать тесты для проверки сущности автора
        CSVAdapter<Author> authorCSVAdapter =
                new CSVAdapter(Author.class, bookAuthorPath);

        Author author1 = new Author(
                "Джордан Белфорт",
                "Нью-Йорк"
            );

        Author author2 = new Author(
                "Олег Тиньков",
                "Полысаево"
        );

        int add1 = authorCSVAdapter.append(author1);
        int add2 = authorCSVAdapter.append(author2);

        Author author = (Author) authorCSVAdapter.read(2);
        assertEquals("Олег Тиньков", author.getName());
        assertEquals("Полысаево", author.getBirthPlace());


    }

    @Test
    public void testAppend() throws IOException {

        String bookFilePath = Paths.get(currentDir,"test-book-file.csv").toString();
        String bookAuthorPath = Paths.get(currentDir,"test-author-file.csv").toString();

        CSVAdapter<Book> bookCsvAdapter =
                new CSVAdapter(Book.class, bookFilePath);

        Book newBook = new Book(
            "Чертоги разума. Убей в себе идиота!",
            "Андрей Курпатов",
            "Психология",
            "978-5-906902-91-7");

        int bookIndex = bookCsvAdapter.append(newBook);

        Book bookAtIndex = (Book) bookCsvAdapter.read(bookIndex);
        assertEquals(newBook, bookAtIndex);

        // TODO: написать тесты для проверки сущности автора
        CSVAdapter<Author> authorCSVAdapter =
                new CSVAdapter(Author.class, bookAuthorPath);

        Author author1 = new Author(
                "Джордан Белфорт",
                "Нью-Йорк"
        );

        int authorIndex = authorCSVAdapter.append(author1);
        Author authorAtIndex = (Author) authorCSVAdapter.read(authorIndex);
        assertEquals(author1, authorAtIndex);

    }
}
