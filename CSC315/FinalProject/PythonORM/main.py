import os
from datetime import date
from sqlalchemy import create_engine, text, select
from sqlalchemy.orm import Session
from person import Person

def displayStatement(session, statement):
    for person in session.scalars(statement):
        print()
        print(person)
        
def main():
    # MYSQL_URL is an environment variable
    engine = create_engine(os.environ.get("MYSQL_URL"))
    
    # *** SQL Query ***
    
    with engine.connect() as connection:
        result = connection.execute(text("SELECT * FROM person\n" +
                                         "ORDER BY FullName"))
        for person in result:
            print(person)
            
    # *** ORM Session ***
    
    with Session(engine) as session:
        
        stmt = select(Person).where(Person.BirthDate < date(2004, 1 , 1))
        displayStatement(session, stmt)    
            
        stmt = select(Person).where(Person.FullName.like("A%"))
        displayStatement(session, stmt)    
    
        stmt = select(Person).where(Person.PersonID == 3)
        displayStatement(session, stmt)    
    

if __name__ == "__main__":
    main()