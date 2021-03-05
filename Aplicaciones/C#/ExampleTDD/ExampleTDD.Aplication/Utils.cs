using System;

namespace ExampleTDD.Aplication
{
    public class Utils: IUtils
    {
        private const int TotalDaysOfYear = 365;
        public bool IsPrime(int num)
        {
            //base case:
            if (num <= 1)
                return false;
            for (int currentNum = 2; currentNum < num; currentNum++)
                if (num % currentNum == 0)
                    return false;
            return true;
        }

        public int GetAge(DateTime date) => (DateTime.Now - date).Days / TotalDaysOfYear;
        
    }
}
