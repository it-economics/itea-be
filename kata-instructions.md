# ITEA 15 - Product Data Persistence

## Intro

### Background story

The ***ITEA Furniture Store*** is a company that primarily sells furniture
and home decoration in their stores. You have been hired as a consultant to
help them in their digital transformation.

<img src="assets/images/ITEA.jpg" width="400" alt="Photo of the ITEA headquarters" />

Please only consider the persistence layer and think about the repository. There is a hexagonal architecture means that there will be an adapter later which transfers the read product from the persistence in our internal domain object. We can ignore this for now. But make sure that we are able to store all the relevant data in an efficient way.

## Tasks

### Task 1: how to persist
Please discuss the different possibilities to persist the data. Some buzzwords and options:
- CSV
- plain text
- json
- Sql
- NoSql
- separate database server
- NoSql MongoDB: you can find a MongoDB sample implementation in branch '15_product_data-persistence_mongoDB' and a sample how MongoDB saves the data structure in the Cheat Sheet below.
- Repository != Database / Repository ≠ Database

<b>Please decide for SQL and H2 In-Memory database at the end.</b>

### Task 2: model data structure

Please model and normalize the data structure. Consider only the products from the current InMemoryProductRepository.java (com.ite.itea.ecommerce.adapters.out.persistence)
<img src="assets/images/product-db-shema.png" width="400" alt="product db shema" />

### Task 3: JPA Repository
- Maven JPA dependency
- Maven H2 dependency
- Maven Hibernate Validators dependency
- Maven Lombok dependency
- Repository Properties

```java

//lombok.*
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter

//jakarta.*
@Entity
@Table(name = "EntityTableName")
class EntityDBO {

    @Id
    private Long id;
    @Column(name="ColumnName")
    private String varCharString; // EntityTableName.ColumnName
    @Lob //H2 specific
    private String textField; //EntityTableName.TEXT_FIELD
    
    @OneToMany(mappedBy = "priceId")
    private Collection<PriceDBO> prices;

    @ManyToOne
    private TypeDBO type;
}
```

```java
interface RepositoryName extends JpaRepository<EntityDBO, Long> {
    //interface, no implementation needed for standard findBy[Attribute]
    //Attribute needs to be defined in EntityClass
    findById(Long id); 
    findByName(String name); //Name is not defined in sample above
}
```

### Task 4: create database structure and insert data / versioning
- Maven Flyway dependency needed
- Flyway Properties needed
- create folder resources/db/migration
  - create sql script with naming pattern 'V[version]__[description].sql' e.g. 'V1__create_table.sql'
  

### Task 5: settings - versioning vs. jpa
- spring.jpa.hibernate.ddl-auto=
    - none
    - <b>validate</b>
    - update
    - create-drop

## Needful Things

### dependencies

```xml
<!--- JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- H2 Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>

<!-- Hibernate validators -->
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>7.0.1.Final</version>
</dependency>

<!-- Flyway -->
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <optional>true</optional>
</dependency>
```

### Application Properties

```properties
#Repository properties
#can be accessed via localhost:9000/h2-console
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
#none, validate, update, create-drop
spring.jpa.hibernate.ddl-auto=validate

#Flyway properties
#flyway default folder 'resources/db/migration'
#flyway default name pattern 'V[version]__[description].sql' e.g. 'V1__create_table.sql'
spring.flyway.url=jdbc:h2:mem:testdb
spring.flyway.user=sa
spring.flyway.password=
```


### MongoDB Product Database Sample
```json
[
  {
    "_id": "18f164b2-ecec-4eb7-8c3f-1ea4cf6a3a0e",
    "name": "Chair \"Olaf\"",
    "imageName": "chairOlaf.png",
    "description": "description of chair Olaf, its quite beautiful and really comfortable.",
    "parts": [ 
        {
          "count": 4,
          "price": "5.00",
          "name": "Leg"
        },
        {
          "count": 1,
          "price": "5.00",
          "name": "Seat"
        },
        {
          "count": 1,
          "price": "5.00",
          "name": "BackRest"
        }
    ],
    "_class": "com.ite.itea.ecommerce.adapters.out.persistence.product.ProductDBO"
  },
  {
    "_id": "2df1845a-55ec-4e39-9b90-7d4dca60c47b",
    "name": "Picture \"Finland\"",
    "imageName": "pictureFinland.png",
    "description": "description of Picture Finland, its really worth seeing.",
    "parts": [
      {
        "count": 1,
        "price": "14.99",
        "name": "Picture"
      }
    ],
    "_class": "com.ite.itea.ecommerce.adapters.out.persistence.product.ProductDBO"
  }
]
```

