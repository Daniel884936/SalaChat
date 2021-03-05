using ExampleTDD.Aplication;
using System;
using Xunit;

namespace ExampleTDD.UnitTest
{
    public class UtlisTest
    {
        private readonly IUtils _util;

        public UtlisTest()
        {
            _util = new Utils();
        }
        
        [Theory]
        [InlineData(7, true)]
        public void Valid_ValueIsPrime(int num, bool expected)
        {
            //act
            var IsPrime = _util.IsPrime(num);

            //assert
            Assert.Equal(expected, IsPrime);
        }

        [Theory]
        [InlineData(7, "2013-4-2")]
        public void Valid_Age(int expected, string strDate)
        {
            //act
            var date = DateTime.Parse(strDate);
            var actual = _util.GetAge(date);

            //assert
            Assert.Equal(expected, actual);
        }
    }
}
