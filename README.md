# libertChan_back

<center>

Front | Back
---| ---
[:tophat:](https://github.com/kim7834/libertChan_Front) | [:bug:](https://github.com/borisBelloc/libertChan_back)

</center>


[Sprint boot](https://start.spring.io/) modules : 
* Spring Web
* Spring Data JPA
* Spring Security
* PostgreSQL Driver


----------

### Project Setting (BACK) Developer profile for JDM.
_allow to use custom username/password_

* create file `application-dev.properties` inside src/main/resources
* add customised credential for database
<details>
		  <summary>exemple</summary>
`spring.datasource.username=postgres
	
spring.datasource.password=password`
  </details>
  
* open JDM setting : 
  - properties > Run/Debug Setting > New
  - inside `Arguments tab` add `-Dspring.profiles.active=dev` inside `VM arguments`
