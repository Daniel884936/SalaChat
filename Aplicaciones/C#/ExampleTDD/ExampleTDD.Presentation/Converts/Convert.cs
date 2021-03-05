using System.Collections.Generic;

namespace ExampleTDD.Presentation.Converts
{
    public abstract class Convert<T> where T : struct
    {
        public Convert()
        {      
            erros = new List<string>();
        }

        protected readonly List<string> erros;
        public T Value { get; protected set; }
        public  bool IsValidConvert { get; protected set; }
        public List<string> Erros => erros;

    }
}
