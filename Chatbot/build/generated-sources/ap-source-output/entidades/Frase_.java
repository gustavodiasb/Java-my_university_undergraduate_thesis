package entidades;

import entidades.Respostas;
import entidades.Significado;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-23T23:19:05")
@StaticMetamodel(Frase.class)
public class Frase_ { 

    public static volatile CollectionAttribute<Frase, Respostas> respostasCollection;
    public static volatile SingularAttribute<Frase, String> frase;
    public static volatile SingularAttribute<Frase, Significado> idSignificado;
    public static volatile SingularAttribute<Frase, Integer> id;

}