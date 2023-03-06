package py.org.smartwater.entities;

import py.com.lib.util.templates.AbstractEntity;
import py.com.lib.util.templates.EntityField;
import py.com.lib.util.templates.ForeignEntityField;

import java.util.Date;

public class Medicion extends AbstractEntity
{
    @Override
    protected EntityField[] getFields()
    {
        Campo[] campos = Campo.values();

        EntityField[] camposEntidad = new EntityField[campos.length];

        for(int i = 0; i < camposEntidad.length; i++)
        {
            camposEntidad[i] = campos[i];
        }

        return camposEntidad;
    }

    @Override
    protected ForeignEntityField[] getForeignFields()
    {
        return new ForeignEntityField[]{};
    }

    public String getEntityName() {
        return "mediciones";
    }

    public Object describe()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getFieldValue(Campo.INSTANTE.getFieldName()));
        sb.append(" | ");
        sb.append(this.getFieldValue(Campo.DEVICE_ID.getFieldName()));
        sb.append(" | ");
        sb.append(this.getFieldValue(Campo.NOMBRE.getFieldName()));
        sb.append(" | ");
        sb.append(this.getFieldValue(Campo.VALOR.getFieldName()));

        return sb.toString();
    }

    public enum Campo implements EntityField
    {
        ID("id", "Id", Long.class, true, false),                                             //0
        INSTANTE("instante", "Instante", Date.class, false, true),
        DEVICE_ID("device_id", "ID de dispositivo", String.class, false, true),                             //3
        NOMBRE("nombre", "Nombre", String.class, false, true),                         //4
        VALOR("valor", "Valor", Double.class, false, false);      //8

        private final String fieldName;
        private final String fieldTitle;
        private final Class<?> fieldType;
        private final boolean primaryKey;
        private final boolean mainField;

        private Campo(String fieldName, String fieldTitle, Class<?> fieldType, boolean primaryKey, boolean mainField)
        {
            this.fieldName = fieldName;
            this.fieldTitle = fieldTitle;
            this.fieldType = fieldType;
            this.primaryKey = primaryKey;
            this.mainField = mainField;
        }

        @Override
        public String getFieldName()
        {
            return fieldName;
        }

        @Override
        public String getFieldTitle()
        {
            return fieldTitle;
        }

        @Override
        public Class<?> getFieldType()
        {
            return fieldType;
        }

        @Override
        public boolean isPrimaryKey()
        {
            return primaryKey;
        }

        @Override
        public boolean isMainField()
        {
            return mainField;
        }
    }
}
