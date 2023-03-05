package py.org.smartwater.etc;

import py.com.lib.database.values.Values;
import py.com.lib.util.values.Variables;

public class Config
{
    public static void initialize()
    {
        Variables.set(Values.Constants.DATABASE_CONTEXT, Values.VariableNames.DATABASE_NAME, "smartwater");
        Variables.set(Values.Constants.DATABASE_CONTEXT, Values.VariableNames.USER_NAME, "postgres");
        Variables.set(Values.Constants.DATABASE_CONTEXT, Values.VariableNames.DATABASE_MANAGER, "POSTGRES");
        Variables.set(Values.Constants.DATABASE_CONTEXT, Values.VariableNames.DEFAULT_SCHEMA, "smartwater");
        Variables.set(Values.Constants.DATABASE_CONTEXT, Values.VariableNames.PASSWORD, "jlwkwkjs");
        Variables.set(Values.Constants.DATABASE_CONTEXT, Values.VariableNames.HOST_ADDRESS, "192.168.0.210:5432");
    }
}