class Exercise
{
    static void Main(string[] args)
    {
        // Question 1

        Console.WriteLine("Question 1:");

        int[] numbers = { 1, 3, 5, 2, 4, 1, 3, 5, 2, 1, 5, 2, 5 };

        Dictionary<int, int> numFrequency = new Dictionary<int, int>();

        for (int i = 0; i < numbers.Length; i++)
        {
            if (numFrequency.ContainsKey(numbers[i]))
            {
                numFrequency[numbers[i]]++;
            }
            else
            {
                numFrequency.Add(numbers[i], 1);
            }
        }

        foreach (var kvp in numFrequency)
        {
            Console.WriteLine($"Number {kvp.Key}: {kvp.Value}");
        }

        Console.WriteLine();

        // Question 2

        Console.WriteLine("Question 2");

        string[] inputNums = Console.ReadLine().Split(" ");

        float average = 0;

        for (int i = 0; i < inputNums.Length; i++)
        {
            average += Convert.ToSingle(inputNums[i]);
            Console.WriteLine($"Number {i} : {inputNums[i]}");
        }

        average /= inputNums.Length;

        int numsGreaterThan = 0;
        int numsLesserThan = 0;

        for (int i = 0; i < inputNums.Length; i++)
        {
            if (Convert.ToSingle(inputNums[i]) > average)
            {
                numsGreaterThan++;
            }
            else
            {
                numsLesserThan++;
            }
        }

        Console.WriteLine($"The average is : {average}");
        Console.WriteLine($"The numbers above the average are : {numsGreaterThan}");
        Console.WriteLine($"The numbers below the average are : {numsLesserThan}");
        Console.WriteLine();

        // Question 3

        numbers = new int[] {1, 2, 4, 5, 7, 9, 3, 8, 0, 9, 6};

        int largestNum = numbers[0];
        int secondLargestNum = numbers[0];

        for (int i = 0; i < numbers.Length; i++)
        {
            if (numbers[i] >= largestNum)
            {
                if (numbers[i] == largestNum)
                {
                    continue;
                }
                secondLargestNum = largestNum;
                largestNum = numbers[i];
            }
            else if (numbers[i] > secondLargestNum)
            {
                secondLargestNum = numbers[i];
            }
        }

        Console.WriteLine($"The second largest number is : {secondLargestNum}");
    }
}