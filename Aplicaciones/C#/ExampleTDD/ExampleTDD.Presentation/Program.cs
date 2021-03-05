using ExampleTDD.Aplication;
using ExampleTDD.Presentation.Messages.Components;
using System;

namespace ExampleTDD.Presentation
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.ForegroundColor = ConsoleColor.Yellow;
            IMenu mainMenu = new MainMenuComponent(new Utils());
            bool IsValidOption;
            int option;
            do
            {
                Console.Clear();
                mainMenu.DisplayMenu();
                IsValidOption = int.TryParse(Console.ReadLine(), out option);
                if (IsValidOption)
                {
                    mainMenu.SelectOption(option);
                }
            } while (option != 3 || !IsValidOption);

            Console.ReadKey();
        }
    }
}
