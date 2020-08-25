package university

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import person.Person
import subject.Subject
import tornadofx.ViewModel

class UniDash {

    val subjectsProperty = SimpleListProperty<SimpleObjectProperty<Subject>>()

   val universityProperty = SimpleObjectProperty<University>()

    val personProperty = SimpleListProperty<SimpleObjectProperty<Person>>()

}

class UniDashViewModel(val uniDash: UniDash): ViewModel(){
    var university = bind {uniDash.universityProperty  }
    var subject = bind {uniDash.subjectsProperty}
    var person = bind {uniDash.personProperty  }

    init{
        university.set(University("Lion Institute", 100000f))
        subject.value.add(SimpleObjectProperty(Subject("IDV", "IDV303", 100, 40, 300f)))
        subject.value.add(SimpleObjectProperty(Subject("IXT", "IXT303", 100, 40, 300f)))

        person.value.add(SimpleObjectProperty(Person(0, "Jake", 0)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 0)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 0)))

        person.value.add(SimpleObjectProperty(Person(0, "Jake", 1)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 1)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 1)))

        person.value.add(SimpleObjectProperty(Person(0, "Jake", 2)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 2)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 2)))

        person.value.add(SimpleObjectProperty(Person(0, "Jake", 3)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 3)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 3)))
    }

    fun start(){

    }

    fun getUniName(): String{
        return university.value.nameProperty.value
    }

    fun getSubjectsCount(): Int{
        return subject.size
    }

    fun getDiStudentCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 0){
                count++
            }
        }
        return count
    }

    fun getDeStudentCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 1){
                count++
            }
        }
        return count
    }

    fun getAcStaffCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 2){
                count++
            }
        }
        return count
    }

    fun getAdStaffCount(): Int{
        var count = 0
        for (student in person){
            if (student.value.type == 3){
                count++
            }
        }
        return count
    }

    fun getAllPeople(): Int{
        return person.size
    }

    fun getName(){
        println(subject[0].value.nameProperty)
        println(person.size)
        println(university.value.nameProperty.value)
    }

    fun addPerson(name: String, type: Int){
        var position = person.size
        position++
        person.value.add(SimpleObjectProperty(Person(position, name, type)))
    }




}