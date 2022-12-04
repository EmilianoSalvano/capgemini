package domain.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;                               //ES EL DE SQL!!!!!
import java.time.LocalDate;

//Los conversores tienen que implementar la interfaz "AttributeConverter"
@Converter(autoApply = true)                        //De esta forma se aplica de forma automatica si lo uso de forma implicita
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate); //Lo mismo que hacer el if, pero en una sola linea.
    }

    @Override
    public LocalDate convertToEntityAttribute(Date date) {
        return date == null ? null : date.toLocalDate();
    }
}
