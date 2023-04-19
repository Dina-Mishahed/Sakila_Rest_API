package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.CategoryRepository;
import gov.iti.jets.service.dto.CategoryDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("category")
public class CategoryResource {
    private CategoryRepository categoryRepository = new CategoryRepository();

    @GET
    @Path("{categoryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryDto getCategoryById(@PathParam("categoryId") int id) {
        return categoryRepository.getCategoryById(id);
    }

//    public List<FilmDto> getFilmsByCategory(@WebParam(name = "categoryId")int id) {
//        return categoryRepository.getFilmsByCategory(id);
//    }

//    public List<CategoryDto> searchCategoryByName(@WebParam(name = "categoryName")String name) {
//        return categoryRepository.searchCategoryByName(name);
//    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

//    public int getFilmsByCategoryNo(@WebParam(name = "categoryId")int id) {
//        return categoryRepository.getFilmsByCategoryNo(id);
//    }
}
