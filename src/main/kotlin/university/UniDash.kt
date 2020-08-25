package university

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import person.Person
import subject.Subject
import tornadofx.ViewModel

class UniDash {

    val subjectsProperty = SimpleListProperty<SimpleObjectProperty<Subject>>()

   //val universityProperty = SimpleObjectProperty<University>()

    val personProperty = SimpleListProperty<SimpleObjectProperty<Person>>()

}

class UniDashViewModel(val uniDash: UniDash): ViewModel(){
//    var university = bind {uniDash.universityProperty  }
    var subject = bind {uniDash.subjectsProperty}
    var person = bind {uniDash.personProperty  }

    init{
        subject.value.add(SimpleObjectProperty(Subject("IDV", "IDV303", 100, 40, 300f)))
        subject.value.add(SimpleObjectProperty(Subject("IXT", "IXT303", 100, 40, 300f)))
        person.value.add(SimpleObjectProperty(Person(0, "Jake", 1)))
    }

    fun start(){

    }

    fun getName(){
        println(subject[0].value.nameProperty)
        println(person[0].value.nameProperty)
    }




}