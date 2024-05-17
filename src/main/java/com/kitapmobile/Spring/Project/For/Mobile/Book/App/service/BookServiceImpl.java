package com.kitapmobile.Spring.Project.For.Mobile.Book.App.service;

import com.kitapmobile.Spring.Project.For.Mobile.Book.App.dto.BookResponse;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Author;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Book;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.entity.Category;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.exception.CommonException;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.factory.BookDtoConvertion;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.AuthorRepository;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.BookRepository;
import com.kitapmobile.Spring.Project.For.Mobile.Book.App.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;
    private AuthorService authorService;
    @Override
    public List<BookResponse> findAll() {
        return BookDtoConvertion.convertBookList(bookRepository.findAll());
    }

    @Override
    public BookResponse findById(Long id) {
        Optional<Book> optional= bookRepository.findById(id);
        if(optional.isPresent()){
            return BookDtoConvertion.convertBook(optional.get());
        }
        throw new CommonException("Girilen id de kitap bulunamadi. ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public BookResponse save(Book book , List<Long> categoryIds , Long authorId) {
        //Bir Book'un birden fazla kategorisi olabilir .
        // Bu yuzden birden fazla categoryId alacak bir list yolluyoruz ve bunlari categories altinda topluyoruz
        //daha sonra Book icerisine hepsini ekliyoruz .
        Author author = authorService.findById(authorId);
        List<Category> categories = categoryRepository.findAllById(categoryIds);
        book.getCategories().addAll(categories);

        for (Category category : categories){
            if (!category.getBooks().contains(book)){
                category.getBooks().add(book);
            }
        }

        author.getBookList().add(book);

         bookRepository.save(book);
         return BookDtoConvertion.convertBook(book);
    }

    @Override
    public Book findByBookId(Long id) {
        Optional<Book> optional = bookRepository.findById(id);

        if (optional.isPresent()){
            return optional.get();
        }
        throw new CommonException("Girilen id de kitap bulunamadi. ID: " + id , HttpStatus.NOT_FOUND);
    }

    @Override
    public String delete(Long id) {
        Book book = findByBookId(id);

        //Book'un iliskili oldugu kategorilerdeki book u remove et.
        for (Category category : book.getCategories()){
            category.getBooks().remove(book);
        }
        book.getCategories().clear();

         bookRepository.delete(book);
        return "Kitap silme islemi basarili.";
    }
}
