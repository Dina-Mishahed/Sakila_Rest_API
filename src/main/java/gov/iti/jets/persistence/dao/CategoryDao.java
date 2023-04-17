package gov.iti.jets.persistence.dao;

import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;

import java.util.List;

public interface CategoryDao {
    CategoryDto getCategoryById(int id);
    List<CategoryDto> getAllCategories();
    List<CategoryDto> searchCategoryByName(String name);
    List<FilmDto> getFilmsByCategory(int id);
    int getFilmsByCategoryNo(int id);
}
