package interfaces;
import models.Books;

import java.util.List;
import java.util.Optional;

public interface IBooksDAO extends GenericDAO <Books, Long>{

    Optional<Books> findById(int id);

    List<Books> findAll();
}