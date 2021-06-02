package br.com.bookstore.api.autor;

import java.text.ParseException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import  static javax.ws.rs.core.Response.Status;

/**
 *
 * @author Tiago
 */
@Path("autores")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class AutorResource {
    
    @PersistenceContext(unitName = "BookstorePU")
    private EntityManager entityManager;
    
    public AutorResource() throws ParseException {
    }
    
    @GET
    public List<Autor> getAutores() {
        //SQL nativo - mais performático, mas pode ter SQL injection e pode ter que reescrever todo o código se trocar de banco
        //return entityManager.createNativeQuery("SELECT * FROM autores", Autor.class).getResultList();
        
        //JPQL
        return entityManager.createQuery("SELECT a FROM Autor a", Autor.class).getResultList();
    }
    
    @GET
    @Path("{id}")
    public Response getAutor(@PathParam("id") int id) {
        Autor autor = findAutor(id);
        
        if (autor == null) {
            return autorNotFoundResponse();
        }
        
        return Response.ok(autor).build();
    }
    
    @POST
    public Response addAutor(Autor autor) {
        entityManager.persist(autor);
        return Response.status(Status.CREATED).entity(autor).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") int id) {
        Autor autor = findAutor(id);
        if (autor == null) {
            return autorNotFoundResponse();
        }
        
        entityManager.remove(autor);
        return Response.noContent().build();
    }
    
    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") int id, Autor autorAtualizado) {
        Autor autor = findAutor(id);
        if (autor == null) {
            return autorNotFoundResponse();
        }
        
        autorAtualizado.setId(id);
        entityManager.merge(autorAtualizado);
        
        return Response.ok(autor).build();
    }
    
    public Autor findAutor(int id) {
        return entityManager.find(Autor.class, id);
    }
    
    public Response autorNotFoundResponse() {
        return Response.status(Status.NOT_FOUND).entity("Autor não encontrado").build();
    }
}
