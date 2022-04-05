package org.zutjmx.webapp.jaxws.services;

import com.github.javafaker.Faker;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import org.zutjmx.webapp.jaxws.models.Curso;

import java.util.Arrays;
import java.util.List;

@WebService(endpointInterface = "org.zutjmx.webapp.jaxws.services.ServicioWs")
public class ServicioWsImpl implements ServicioWs {

    private int contador;

    @Override
    @WebMethod
    public String saludar(String persona) {
        System.out.println(":: Dentro del Servicio Web con instancia: " + this + " ::");
        contador++;
        System.out.println(":: Valor de contador en el método saludar => " + contador +" ::");
        return "Hola ".concat(persona);
    }

    @Override
    @WebMethod
    public List<Curso> listar() {
        Faker faker = new Faker();
        return Arrays.asList(
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title()),
                new Curso(faker.book().title())
        );
    }

    @Override
    @WebMethod
    public Curso crear(Curso curso) {
        System.out.println(":: Curso => " + curso.getNombre() + " guardado con éxito ::");
        Curso cursoAGuardar = new Curso();
        cursoAGuardar.setNombre(curso.getNombre());
        return cursoAGuardar;
    }
}
