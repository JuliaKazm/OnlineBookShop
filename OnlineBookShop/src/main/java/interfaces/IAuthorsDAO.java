package interfaces;

import models.Authors;

import java.util.List;
import java.util.Optional;

public interface IAuthorsDAO extends GenericDAO <Authors, Long>{
    Optional<Authors> findById(int id);

    Optional<Authors> findById(Long id);

    List<Authors> findAll();

    void delete(Long id);
}