using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CSharp440
{
    public class Person
    {
        // variable hold the first name
        private string firstName;
        // variable hold the last name
        private string lastName;
        // variable hold the email address
        private string emailAddress;
        // variable hold the date of birth (the datetype should be DateTime) 
        private DateTime birthDate;

        // constructor to initialize the user's first name, last name, email, and date of birth
        public Person(string first, string last, string email, DateTime dob)
        {
            firstName = first;
            lastName = last;
            emailAddress = email;
            birthDate = dob;
        }
        // constructor to initialize the user's first name, last name, email
        public Person(string first, string last, string email)
        {
            firstName = first;
            lastName = last;
            emailAddress = email;
        }
        // constructor to initialize the user's first name, last name, and date of birth
        public Person(string first, string last, DateTime dob)
        {
            firstName = first;
            lastName = last;
            birthDate = dob;
        }

        // property for first name
        public string FirstName
        {
            get { return firstName; }
            set { firstName = value; }
        }
        // property for last name
        public string LastName
        {
            get { return lastName; }
            set { lastName = value; }
        }
        // protper for emial address
        public string Email
        {
            get { return emailAddress; }
            set { emailAddress = value; }
        }
        // property for date of birth
        public DateTime BirthDate
        {
            get { return birthDate; }
            set { birthDate = value; }
        }
        // read only property called Adult: whether or not the person is over 18
        public string Adult
        {
            get
            {
                DateTime today = DateTime.Now;
                int ageInDays = today.Subtract(birthDate).Days;

                if (ageInDays / 365 < 18)
                {
                    return "You are not an Adult";
                }
                else
                {
                    return "You are an Adult";
                }
            }
        }
        // read only property called Birthday: whether or not today is the person's birthday
        public string Birthday
        {
            get
            {
                DateTime today = DateTime.Now;
                
                if (today.Day == birthDate.Day && today.Month == birthDate.Month)
                {
                    return "Happy Birthday!";
                }
                else
                {
                    return "Today is not your birthday.";
                }
            }
        }
        // static function to request the person's info through console
        public static Person PersonInfoRequester()
        {
            Console.WriteLine("Enter your firstName:");
            string firstName = Console.ReadLine();
            Console.WriteLine("Enter your LastName:");
            string lastName = Console.ReadLine();
            Console.WriteLine("Enter your Email:");
            string email = Console.ReadLine();
            Console.WriteLine("Enter your birth year:");
            int year = int.Parse(Console.ReadLine());
	    // the year has to be validated: the person's age cannot be negative value, or person's age cannot be greate than 135
            if(DateTime.Now.Year < year)
            {
                Console.WriteLine("Please enter a valid year");
                Environment.Exit(0);
            }
            Console.WriteLine("Enter your birth month:");
            int month = int.Parse(Console.ReadLine());
            Console.WriteLine("Enter your birth day:");
            int day = int.Parse(Console.ReadLine());
            DateTime birthday = new DateTime(year, month, day);
            Person p = new Person(firstName, lastName, email, birthday);
            return p;
        }
        // static function to print out person's info
        public static void PrintPersonInfo(Person p)
        {
            Console.WriteLine();
            Console.Write($"Hello {p.FirstName} ");
            Console.WriteLine(p.LastName);
            Console.WriteLine($"You email address is: {p.Email}");
            Console.WriteLine(p.Adult);
            Console.WriteLine(p.Birthday);
        }
        public static void Main(string[] args)
        {
            Person p = PersonInfoRequester();
            PrintPersonInfo(p);

        }

    }
}
