package View

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleListProperty
import javafx.beans.property.SimpleObjectProperty
import javafx.beans.property.SimpleStringProperty
import javafx.collections.ObservableList
import javafx.geometry.Pos
import javafx.scene.paint.Color
import javafx.scene.text.TextAlignment
import person.Person
import subject.Subject
import tornadofx.*
import university.UniDash
import university.UniDashViewModel

class UniView: View() {

    val uniDashViewModel = UniDashViewModel(UniDash())

    //Bindings
    var fund = SimpleStringProperty()
    var subjects = SimpleStringProperty()
    var diploma = SimpleStringProperty()
    var degree = SimpleStringProperty()
    var acad = SimpleStringProperty()
    var admin = SimpleStringProperty()
    var allPeople = SimpleStringProperty()
    val people = SimpleListProperty<SimpleObjectProperty<Person>>()
    val moneyFees = SimpleStringProperty()
    val staffPay = SimpleStringProperty()
    val endMonthPro = SimpleStringProperty()
    val endPoolFunds = SimpleStringProperty()
    val peopleList = mutableListOf("Test").asObservable()

    fun update(){
        fund.set("Funds R" + uniDashViewModel.getUniPool().toString())
        subjects.set("Subjects: " + uniDashViewModel.getSubjectsCount().toString())
        diploma.set("Diploma Students: " + uniDashViewModel.getDiStudentCount().toString())
        degree.set("Degree Students: " + uniDashViewModel.getDeStudentCount().toString())
        acad.set("Academic Staff: " + uniDashViewModel.getAcStaffCount().toString())
        admin.set("Administrative Staff: " + uniDashViewModel.getAdStaffCount().toString())
        allPeople.set("All people: " + uniDashViewModel.getAllPeople().toString())
        people.set(uniDashViewModel.getPeople())
        println(uniDashViewModel.getPersonByNo(1)?.name)
        val num = uniDashViewModel.getAllPeople()
        peopleList.clear()
        for (i in people){
            println(i.value.name)
            peopleList.add(i.value.name)
        }

        println(peopleList)


        moneyFees.set("Students will pay R" + uniDashViewModel.getMoneyFees().toString())
        staffPay.set("Staff will be Payed R" + uniDashViewModel.getStaffPayment().toString())
        var projection =   uniDashViewModel.getMoneyFees() - uniDashViewModel.getStaffPayment()
        endMonthPro.set("End of Month Projection R$projection")
        var poolProjected = uniDashViewModel.getUniPool() - uniDashViewModel.getStaffPayment() - uniDashViewModel.getMoneyFees()
        endPoolFunds.set("Projected Pool Funds R" + poolProjected)
    }

    override val root = vbox {
        val subject = uniDashViewModel.subject.value
        borderpane {
            update()
            print((people[0].name))


            left = vbox() {
                setPrefSize(200.0, 960.0)
                useMaxHeight = true

                label ("UniDash"){
                    setPrefSize(200.0, 30.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (uniDashViewModel.getUniName()){
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (){
                    textProperty().bind(fund)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 20.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (){
                    textProperty().bind(subjects)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }
                label (){
                    textProperty().bind(diploma)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (){
                    textProperty().bind(degree)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (){
                    textProperty().bind(acad)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (){
                    textProperty().bind(admin)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }

                label (){
                    textProperty().bind(allPeople)
                    setPrefSize(200.0, 10.0)
                    vboxConstraints {
                        marginTop = 10.0
                        marginBottom = 10.0
                        alignment = Pos.CENTER
                    }
                    style{
                        textFill = Color.rgb(255, 255, 255)
                        textAlignment = TextAlignment.CENTER
                    }
                }



                style{
                    backgroundColor += Color.rgb(22, 41, 53)
                }

            }

            top = vbox{
                setPrefSize(100.0, 30.0)

                useMaxWidth = true

                style{
                    backgroundColor += Color.rgb(22, 41, 53)
                }
            }


            center = vbox{
                setPrefSize(1000.0, 960.0)
                useMaxWidth = true
                style{
                    backgroundColor += Color.rgb(20, 31, 38)
                }

                borderpane {

                    left = vbox {
                        label ("Users"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }
                        val model = ViewModel()
                        val search = model.bind { SimpleStringProperty() }
                        form{
                            setPrefSize(50.0, 10.0)
                            fieldset {
                                field("Search"){
                                    style{
                                        textFill = Color.rgb(255, 255, 255)
                                    }
                                   textfield(search)
                                }

                            }

                            button("Search") {
                                action {
                                    uniDashViewModel.search(search.value.toString())
                                    println("Search")
                                    search.value = ""
                                    update()
                                }

                            }

                        }


                        listview<String> {

                            items.setAll(peopleList)

                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 20.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 20.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                   right = vbox {
                        label ("Subjects"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                       tableview<Subject> {
                           items = listOf(
                                   Subject(0,"IDV", "IDV303", 100, 40, 300f),
                                   Subject(1,"IXT", "IXT303", 100, 40, 300f)
                           ).observable()

                           column("ID",Subject::idProperty)
                           column("NAME",Subject::name)
                           column("CODE",Subject::code)
                           column("CREDITS",Subject::credits)
                           column("HOURS",Subject::hours)
                           column("PRICE",Subject::price)

                       }

                        setPrefSize(450.0, 302.0)

                       vboxConstraints {
                           marginTop = 30.0
                           marginLeft = 30.0
                           marginRight = 30.0
                           marginBottom = 30.0
                       }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 20.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 20.0
                        alignment = Pos.CENTER
                    }


                }

                borderpane {

                    left = vbox {
                        label ("Register people"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val type = model.bind { SimpleStringProperty() }


                        form{
                            fieldset {
                                field("Name"){
                                    textfield(name)
                                }

                                field("Type"){
                                    textfield(type)
                                }
                            }

                            button("Add Person") {
                                action {
                                    println(uniDashViewModel.getAllPeople().toString() + " Before Add")
                                    uniDashViewModel.addPerson(name.value.toString(),type.value.toInt())
                                    println("Added Person")

                                    println(uniDashViewModel.getAllPeople().toString() + " After Add")
                                    name.value = ""
                                    type.value = ""

                                    update()

                                }
                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 20.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 20.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                    right = vbox {
                        label ("Create a new subject"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val code = model.bind { SimpleStringProperty() }
                        val credits = model.bind { SimpleStringProperty() }
                        val hours = model.bind { SimpleStringProperty() }
                        val price = model.bind { SimpleStringProperty() }


                        form{
                            fieldset {
                                field("Name"){
                                    textfield(name)
                                }

                                field("Code"){
                                    textfield(code)
                                }
                                field("Credits"){
                                    textfield(credits)
                                }
                                field("Hours"){
                                    textfield(hours)
                                }
                                field("Price"){
                                    textfield(price)
                                }
                            }

                            button("Add Subject") {
                                action {
                                    println(uniDashViewModel.getSubjectsCount().toString() + " Before Add")
                                    uniDashViewModel.addSubject(name.value.toString(), code.value.toString(), credits.value.toInt(), hours.value.toInt(), price.value.toFloat())
                                    println("Added Person")

                                    println(uniDashViewModel.getSubjectsCount().toString() + " After Add")
                                    name.value = ""
                                    code.value = ""
                                    credits.value = ""
                                    hours.value = ""
                                    price.value = ""
                                    update()

                                }
                            }
                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 30.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 30.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 20.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 20.0
                        alignment = Pos.CENTER
                    }


                }

                borderpane {

                    left = vbox {
                        label ("End of Month Balance"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        label (){
                            textProperty().bind(moneyFees)
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        label (){
                            textProperty().bind(staffPay)
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }
                        label (){
                            textProperty().bind(endMonthPro)
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        label (){
                            textProperty().bind(endPoolFunds)
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        setPrefSize(450.0, 320.0)

                        vboxConstraints {
                            marginTop = 20.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 20.0
                            alignment = Pos.CENTER
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }
                    right = vbox {
                        label ("Add subject to people"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        val model = ViewModel()
                        val name = model.bind { SimpleStringProperty() }
                        val id = model.bind { SimpleStringProperty() }


                        form{
                            fieldset {
                                field("Persons Id"){
                                    textfield(name)
                                }

                                field("Subject Id"){
                                    textfield(id)
                                }
                            }

                            button("Add Subject") {
                                action {
                                    println(uniDashViewModel.getRegisteredSubjectCount().toString() + " Before Add")
                                    uniDashViewModel.addSubjectToPerson(name.value.toInt(),id.value.toInt())
                                    println("Added Person")

                                    println(uniDashViewModel.getRegisteredSubjectCount().toString() + " After Add")
                                    name.value = ""
                                    id.value = ""
                                    update()

                                }
                            }
                        }

                        setPrefSize(450.0, 302.0)

                        vboxConstraints {
                            marginTop = 20.0
                            marginLeft = 30.0
                            marginRight = 30.0
                            marginBottom = 20.0
                        }
                        style{
                            backgroundColor += Color.rgb(30, 31, 38)
                        }
                    }

                    vboxConstraints {
                        marginTop = 30.0
                        marginLeft = 30.0
                        marginRight = 30.0
                        marginBottom = 30.0
                        alignment = Pos.CENTER
                    }


                }

            }

        }
    }




}