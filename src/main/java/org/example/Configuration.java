package org.example;

import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.ejb.Singleton;


/**
 * Adnotacja @DataSourceDefinition konfiguruje źródło połączeń JDBC (DataSource) do bazy H2 w trybie in-memory z pulą połączeń. Obiekt źródła połączeń zostanie utworzony jako zasób na serwerze aplikacyjnym w momencie instalacji aplikacji.
 * Klasa z adnotacją @Singleton reprezentuje komponent EJB, ktory zostanie utworzony w aplikacji.
 * W tym przykładzie komponent nie zawiera żadnej implementacji i służy jedynie jako źrodło konfguracji zamieszczonej w adnotacji @DataSourceDefinition
 */
@DataSourceDefinition(
        name = "java:global/ProjectDataSource",
        className = "org.h2.jdbcx.JdbcDataSource",
        url = "jdbc:h2:mem:test2;DB_CLOSE_DELAY=-1",
        minPoolSize = 1,
        initialPoolSize = 1,
        user = "sa",
        password = ""
)
@Singleton
public class Configuration {
}