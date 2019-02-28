package hw6;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import enums.Users;
import io.cucumber.cucumberexpressions.ParameterType;
import io.cucumber.cucumberexpressions.Transformer;
import io.cucumber.datatable.DataTableType;
import pageObjects.utils.SuperHero;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class TypeRegistryConfiguration implements TypeRegistryConfigurer {
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

        String users = "";
        for(Users user : Users.values())
        {
            users += user.toString() + "|";
        }
        if(!users.isEmpty())
        {
            users = users.substring(0, users.length() - 2);
        }

        typeRegistry.defineParameterType(new ParameterType<>(
                "Users",           // name
                "Users.(\\w+)",           // regexp
                Users.class,       // type
                (String s) -> {
                    return Users.valueOf(s);
                }      // transformer function
            ));
    }
}
