package gov.iti.jets.persistence.daoImp;

import gov.iti.jets.persistence.dao.CategoryDao;
import gov.iti.jets.persistence.entity.Actor;
import gov.iti.jets.persistence.entity.Category;
import gov.iti.jets.persistence.entity.FilmCategory;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.ActorDto;
import gov.iti.jets.service.dto.CategoryDto;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.mapper.CategoryMapper;
import gov.iti.jets.service.mapper.FilmMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImp extends BaseDAO implements CategoryDao {
    CategoryMapper categoryMapper;
    FilmMapper filmMapper;
    public CategoryDaoImp(){
        categoryMapper = Mappers.getMapper(CategoryMapper.class);
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }
    @Override
    public CategoryDto getCategoryById(int id) {
        Category category = (Category) get(Category.class,"categoryId",id);
        return categoryMapper.toDto(category);
//        EntityManager entityManager = null;
//        try {
//            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
//            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
//            Root<Category> root = cq.from(Category.class);
//            cq.where(cb.equal(root.get("categoryId"), id));
//            TypedQuery<Category> query = entityManager.createQuery(cq);
//            CategoryDto categoryDto =  categoryMapper.toDto(query.getSingleResult());
//            return categoryDto;
//        } catch (NoResultException e) {
//            return null;
//        }finally{
//            entityManager.close();
//        }
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = getAll(Category.class);
        List<CategoryDto> categoryDtoList = categoryList.stream().map((category -> categoryMapper.toDto(category))).toList();
        return categoryDtoList;
    }

    @Override
    public List<CategoryDto> searchCategoryByName(String name) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> root = cq.from(Category.class);
            cq.select(root);
            if (name != null && !name.isEmpty()) {
                // Use the like operator to search for categories that contain the given string in their name
                Predicate predicate = cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
                cq.where(predicate);
            }
            TypedQuery<Category> query = entityManager.createQuery(cq);
            List<Category> categories = query.getResultList();
            List<CategoryDto> categoryDtos = new ArrayList<>();
            for (Category category : categories) {
                CategoryDto categoryDto = categoryMapper.toDto(category);
                categoryDtos.add(categoryDto);
            }
            return categoryDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public List<FilmDto> getFilmsByCategory(int id) {
        EntityManager entityManager = null;
        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Category> cq = cb.createQuery(Category.class);
            Root<Category> root = cq.from(Category.class);
            cq.where(cb.equal(root.get("categoryId"), id));
            TypedQuery<Category> query = entityManager.createQuery(cq);
            List<FilmCategory> filmCategoryList = query.getSingleResult().getFilmCategoryList();
            List<FilmDto> filmDtoList = filmCategoryList.stream().map(FilmCategory::getFilm).map((film -> filmMapper.toDto(film))).toList();
            return filmDtoList;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public int getFilmsByCategoryNo(int id) {
        return 0;
    }

}
