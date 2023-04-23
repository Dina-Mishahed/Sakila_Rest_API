package gov.iti.jets.service.rest;

import gov.iti.jets.persistence.repository.CategoryRepository;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("categories")
public class CategoryResource {
    private CategoryRepository categoryRepository = new CategoryRepository();

    @GET
    @Path("{categoryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public CategoryDto getCategoryById(@PathParam("categoryId") int id) {
        return categoryRepository.getCategoryById(id);
    }

    @GET
    @Path("getFilms/{categoryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FilmDto> getFilmsByCategory(@PathParam("categoryId")int id) {
        return categoryRepository.getFilmsByCategory(id);
    }


    @GET
    @Path("searchCategoryByName/{categoryName}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> searchCategoryByName(@PathParam("categoryName")String name) {
        return categoryRepository.searchCategoryByName(name);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @GET
    @Path("getFilmsByCategoryNo/{categoryId: [0-9]+}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getFilmsByCategoryNo(@PathParam("categoryId")int id) {
        return categoryRepository.getFilmsByCategoryNo(id);
    }
}
