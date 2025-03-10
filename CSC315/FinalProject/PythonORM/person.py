from sqlalchemy import String, Integer, Date
from sqlalchemy.orm import DeclarativeBase, Mapped, mapped_column

class Base(DeclarativeBase):
    pass

class Person(Base):
    __tablename__ = "person"
    
    PersonID: Mapped[int] = mapped_column(Integer, primary_key=True)
    FullName: Mapped[str] = mapped_column(String(45))
    BirthDate: Mapped[str] = mapped_column(Date)
    
    def __str__(self) -> str:
        return f"""Memory Address: {super().__str__()}
ID: {self.PersonID} Name: {self.FullName}, Birth Date: {self.BirthDate}"""
