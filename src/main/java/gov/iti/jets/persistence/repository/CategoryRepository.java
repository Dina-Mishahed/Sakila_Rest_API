package gov.iti.jets.persistence.repository;

import gov.iti.jets.persistence.dao.CategoryDao;
import gov.iti.jets.persistence.daoImp.CategoryDaoImp;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;

import java.util.List;

public class CategoryRepository implements CategoryDao {
    CategoryDao categoryDao ;
    public CategoryRepository(){
        categoryDao = new CategoryDaoImp();
    }
    @Override
    public CategoryDto getCategoryById(int id) {
        return categoryDao.getCategoryById(id);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    @Override
    public List<CategoryDto> searchCategoryByName(String name) {
        return categoryDao.searchCategoryByName(name);
    }

    @Override
    public List<FilmDto> getFilmsByCategory(int id) {
        return categoryDao.getFilmsByCategory(id);
    }

    @Override
    public int getFilmsByCategoryNo(int id) {
        return categoryDao.getFilmsByCategoryNo(id);
    }
}
