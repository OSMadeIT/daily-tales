package com.osmadeit.mystory.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-11T15:59:57")
@StaticMetamodel(Stories.class)
public class Stories_ { 

    public static volatile SingularAttribute<Stories, Date> createdAt;
    public static volatile SingularAttribute<Stories, Integer> id;
    public static volatile SingularAttribute<Stories, String> title;
    public static volatile SingularAttribute<Stories, String> story;

}