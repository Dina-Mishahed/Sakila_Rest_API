package gov.iti.jets.persistence.daoImp;

import java.util.ArrayList;
import java.util.List;

import gov.iti.jets.persistence.dao.FilmDao;
import gov.iti.jets.persistence.entity.Film;
import gov.iti.jets.persistence.util.HibernateEntityManagerFactory;
import gov.iti.jets.service.dto.FilmDto;
import gov.iti.jets.service.mapper.FilmMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.mapstruct.factory.Mappers;

public class FilmDaoImp implements FilmDao{
    private FilmMapper filmMapper;
    public FilmDaoImp(){
        filmMapper = Mappers.getMapper(FilmMapper.class);
    }
    @Override
    public Boolean createFilm(FilmDto film) {
        return null;
    }

    @Override
    public FilmDto getFilmById(int id) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Film> cq = cb.createQuery(Film.class);
            Root<Film> root = cq.from(Film.class);
            cq.where(cb.equal(root.get("filmId"), id));
            TypedQuery<Film> query = entityManager.createQuery(cq);
            FilmDto filmDto =  filmMapper.toDto(query.getSingleResult());
            return filmDto;
        } catch (NoResultException e) {
            return null;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Boolean updateFilm(FilmDto filmDto) {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            Film film = filmMapper.toEntity(filmDto);
            entityManager.getTransaction().begin();
            entityManager.merge(film);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }

    @Override
    public Boolean deleteFilm(int id) {
        return null;
    }

    @Override
    public List<FilmDto> getAllFilms() {
        EntityManager entityManager = null;

        try {
            entityManager = HibernateEntityManagerFactory.getEntityManagerFactory().createEntityManager();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<Film> cq = cb.createQuery(Film.class);
            Root<Film> root = cq.from(Film.class);
            cq.select(root);

            TypedQuery<Film> query = entityManager.createQuery(cq);
            List<Film> films = query.getResultList();
            List<FilmDto> filmDtos = new ArrayList<>();
            for (Film film : films) {
                FilmDto filmDao = filmMapper.toDto(film);
                filmDtos.add(filmDao);
            }
            return filmDtos;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw e;
        }finally{
            entityManager.close();
        }
    }
}
