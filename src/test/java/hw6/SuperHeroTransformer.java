package hw6;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import io.cucumber.datatable.DataTableType;
import pageObjects.utils.SuperHero;

import java.util.Locale;
import java.util.Map;

public class SuperHeroTransformer implements TypeRegistryConfigurer {
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry typeRegistry) {
        typeRegistry.defineDataTableType(new DataTableType(SuperHero.class, (Map<String, String> row) -> {
            Integer number = Integer.parseInt(row.get("Number"));
            String user = row.get("User");
            String description = row.get("Description");
            return new SuperHero(number, user, description);
        }));
    }
}
