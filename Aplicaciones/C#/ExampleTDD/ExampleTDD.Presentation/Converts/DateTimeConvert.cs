using System;

namespace ExampleTDD.Presentation.Converts
{
    public class DateTimeConvert: Convert<DateTime>
    {
        public static  DateTimeConvert ConvertToDatime(string value)
        {
            DateTimeConvert dateTimeConvert = new DateTimeConvert();
            bool isDateTime = DateTime.TryParse(value, out DateTime dateTimeValue);
            if (isDateTime)
            {
                dateTimeConvert.Value =  dateTimeValue;
                dateTimeConvert.IsValidConvert = true;
                return dateTimeConvert;
            }
            dateTimeConvert.IsValidConvert = false;
            dateTimeConvert.erros.Add($"Invalid format, format valid: 'yyyy-mm-dd' example: 1999-02-05");
            return dateTimeConvert;
        }
    }
}
