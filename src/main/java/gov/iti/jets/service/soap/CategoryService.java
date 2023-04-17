package gov.iti.jets.service.soap;

import gov.iti.jets.persistence.repository.ActorRepository;
import gov.iti.jets.persistence.repository.CategoryRepository;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

@WebService
public class CategoryService {
    private CategoryRepository categoryRepository = new CategoryRepository();
    @WebMethod(operationName = "FindCategoryById")
    public CategoryDto getCategoryById(@WebParam(name = "categoryId")int id) {
        return categoryRepository.getCategoryById(id);
    }
    @WebMethod(operationName = "FindFilmsByCategory")
    public List<FilmDto> getFilmsByCategory(@WebParam(name = "categoryId")int id) {
        return categoryRepository.getFilmsByCategory(id);
    }
    @WebMethod(operationName = "FindCategoryByName")
    public List<CategoryDto> searchCategoryByName(@WebParam(name = "categoryName")String name) {
        return categoryRepository.searchCategoryByName(name);
    }
    @WebMethod(operationName = "FindAllCategories")
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.getAllCategories();
    }
    @WebMethod(operationName = "CountNoOfFilmsByCategory")
    public int getFilmsByCategoryNo(@WebParam(name = "categoryId")int id) {
        return categoryRepository.getFilmsByCategoryNo(id);
    }
}
