using ExampleTDD.Aplication;
using ExampleTDD.Presentation.Converts;
using System;

namespace ExampleTDD.Presentation.Messages.Components
{
    public class MainMenuComponent: IMenu
    {
        private readonly IUtils _utils;
        private const string line = "------------------------------------------------";
        public MainMenuComponent(IUtils utils)
        {
            _utils = utils;
        }
        public  void DisplayMenu()
        {
            Console.Write(
                $"{line}Welcome to utils{line}" +
                $"\n" +
                $"\nOption 1: Get age" +
                $"\nOption 2: Is prime" +
                $"\nClose" +
                $"\n" +
                $"\nnput option: "
                );
        }

        public  void SelectOption(int option)
        {
            switch (option)
            {
                case 1:
                    AgeOption();
                    Console.ReadKey();
                    break;
                case 2:
                    PirmeOption();
                    Console.ReadKey();
                    break;
            }
        }

        private  void PirmeOption()
        {
            Console.Write($"Prime: ");
            var intConvert = IntConvert.ConvertToInt(Console.ReadLine());
            if (intConvert.IsValidConvert)
            {
                Console.Write($"Is prime: {_utils.IsPrime(intConvert.Value)}");
                return;
            }
            intConvert.Erros.ForEach(delegate (string error)
            {
                Console.WriteLine(error);
            });
            return;
        }

        private  void AgeOption()
        {
            Console.Write($"Date: ");
            var dateTimeConvert = DateTimeConvert.ConvertToDatime(Console.ReadLine());
            if (dateTimeConvert.IsValidConvert)
            {
                Console.Write($"Age: {_utils.GetAge(dateTimeConvert.Value)}");
                return;
            }
            dateTimeConvert.Erros.ForEach(delegate (string error)
            {
                Console.WriteLine(error);
            });
            return;
        }
    }
}
