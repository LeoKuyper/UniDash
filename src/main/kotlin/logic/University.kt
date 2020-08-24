package logic

class University(private var name: String) {
    private var people = mutableListOf<Person>()
    private var subjects = mutableListOf<Subject>()
    private var pool = 0f


    //People
    fun getPeople(): String {
        return people.size.toString()
    }

    fun addPeople(name: String, type: Int){
        var int = people.size
        people.add(Person(int,name,type))
    }

    fun getPeopleName(): String{
        return people[0].getPersonName()
    }

    //Uni
    fun getUniName(): String{
        return name
    }

    fun setUniName(string: String){
        name = string
    }


    //Subjects
    fun getSubjects(): String{
        return subjects.size.toString()
    }

    fun addSubjects(name: String, code: String, credits: Int, hours: Int, price: Int){
        subjects.add(Subject(name, code, credits, hours, price))
    }

    fun listSubjects(){
        println("Subjects available: ")
        subjects.forEach(){
            println(it.name + " " + it.code + " R" +it.price)
        }
    }

    //Pool
    fun getPool(): String{
        return pool.toString()
    }

    fun setPool(float: Float){
        pool = float
    }

    fun addPool(float: Float){
        pool + float
    }

    fun removePool(float: Float){
        pool - float
    }


}


