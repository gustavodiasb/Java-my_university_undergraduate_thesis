package entidades;

import entidades.Frase;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-06-23T23:19:05")
@StaticMetamodel(Significado.class)
public class Significado_ { 

    public static volatile SingularAttribute<Significado, String> significado;
    public static volatile CollectionAttribute<Significado, Frase> fraseCollection;
    public static volatile SingularAttribute<Significado, Integer> id;

}