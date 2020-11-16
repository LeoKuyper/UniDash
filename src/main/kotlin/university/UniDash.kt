package university

import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import person.Person
import subject.Subject
import tornadofx.ViewModel
import java.awt.List

class UniDash {

    val subjectsProperty = SimpleListProperty<SimpleObjectProperty<Subject>>()

   val universityProperty = SimpleObjectProperty<University>()

    val personProperty = SimpleListProperty<SimpleObjectProperty<Person>>()

}

class UniDashViewModel(val uniDash: UniDash): ViewModel(){
    var university = bind {uniDash.universityProperty  }
    var subject = bind {uniDash.subjectsProperty}
    var person = bind {uniDash.personProperty  }

    var personSubject = Array(0) {0}
    var subjectPerson = Array(0) {0}

    init{
        university.set(University("Lion Institute", 100000f))

        addSubject("IDV", "IDV303", 100, 40, 300f)
        addSubject("IXT", "IXT303", 100, 40, 300f)

        addPerson("Ken", 0)

        addPerson("Rocco", 1)
        addPerson("Ollie", 1)

        addPerson("Jesse", 2)

        addPerson("Jake", 3)

        addSubjectToPerson(0,1)
        addSubjectToPerson(0,1)
        addSubjectToPerson(2,1)
        addSubjectToPerson(2,0)

        getPersonSubjects(0)

    }

    fun getPersonByNo(number:Int): Person? {
        return person[number].value
    }

    fun getPeople(): SimpleListProperty<SimpleObjectProperty<Person>> {
        return person
    }


    fun getMoneyFees():Float{
        var cost = 0f
        for (su in subjectPerson){
            for (sub in subject){
                if (su == sub.value.id)
                    cost += sub.value.price
            }
        }

        return cost*4
    }

    fun getStaffPayment():Float{
        var cost = 0f
        for (st in person){
            if (st.value.type ==3 ){
                cost += 15000f
            }
        }
        for (st in personSubject){

            if (2 == st){
                var count = 0
                for (sb in subject){
                    if (sb.value.id == count){
                        var costs = sb.value.hours * 400
                        cost += costs
                    }
                    count ++
                }
            }
        }
        return cost
    }


    fun getRegisteredSubjectCount() :Int{
        return subjectPerson.size
    }

    fun getPersonSubjects(id: Int):String{
        var count = 0
        var subjects = Array(0) {0}
        println("id $id")

        for (person in personSubject){
            println("Person Id " + person)

            if (person == id){

                subjects += subjectPerson[count]
            }
            count ++
        }
        println(GetPeopleByNo(id).name.toString() + " " + subjects.toString())
        return subjects.size.toString()


    }

    fun addSubjectToPerson(person: Int, subject: Int){

        personSubject += person
        subjectPerson += subject
        println(personSubject.size)

    }

    fun getUniPool(): Float{
        return university.value.poolProperty.value
    }

    fun getUniName(): String{
        return university.value.nameProperty.value
    }

    fun getSubjectsCount(): Int{
        return subject.size
    }

    fun getSubjectsName(id: Int): String{
        println(subject[id].name)
        return subject[id].value.name
    }
    fun getSubjectsCode(id: Int): String{
        println(subject[id].name)
        return subject[id].value.code
    }
    fun getSubjectsCredits(id: Int): String{
        println(subject[id].name)
        return subject[id].value.credits.toString()
    }
    fun getSubjectsHours(id: Int): String{
        println(subject[id].name)
        return subject[id].value.hours.toString()
    }
    fun getSubjectsPrice(id: Int): String{
        println(subject[id].name)
        return subject[id].value.price.toString()
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

    fun GetPeopleByNo(number:Int): Person{
        return person[number].value
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
        person.value.add(SimpleObjectProperty(Person(position, name, type)))
        position++

    }

    fun addSubject(name: String, code: String,  credits: Int, hours: Int,  price: Float){
        var position = subject.size
        subject.value.add(SimpleObjectProperty(Subject(position,name,code,credits,hours,price)))
        position
    }

    fun search(data:String){
        for (student in person){
            if (student.value.id.toString() == data){
                println( student.value.name + " ID: " + student.value.id.toString()+ " Type: " + student.value.type.toString())
            }
            if (student.value.name.toLowerCase() == data.toLowerCase()){
                println( student.value.name + " ID: " + student.value.id.toString()+ " Type: " + student.value.type.toString())
            }
        }
    }
}