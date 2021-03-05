namespace ExampleTDD.Presentation.Converts
{

    public class IntConvert: Convert<int>
    {
        public static IntConvert ConvertToInt(string value)
        {
            IntConvert intConvert = new IntConvert();
            bool isLong = long.TryParse(value, out long longValue);
            if (isLong)
            {
                if (IsLessThanIntMin(longValue))
                {
                    intConvert.IsValidConvert = false;
                    intConvert.erros.Add($"Must be greather than {int.MinValue}");
                }
                else if (IsGreaterThanIntMax(longValue))
                {
                    intConvert.IsValidConvert = false;
                    intConvert.erros.Add($"Must be less than {int.MaxValue}");
                }
                else
                {
                    intConvert.IsValidConvert = true; ;
                    intConvert.Value =(int)longValue;
                }
                return intConvert;
            }
            intConvert.IsValidConvert = false;
            intConvert.erros.Add($"Invalid format, must be a integer num ");
            return intConvert;
        }

        private static bool IsLessThanIntMin(long value) => value < int.MinValue;
        private static bool IsGreaterThanIntMax(long value) => value > int.MaxValue;
    }
}
