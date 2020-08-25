package View

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


    override val root = vbox {
        val subject = uniDashViewModel.subject.value
        borderpane {



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

                label ("Funds R" + uniDashViewModel.getUniPool().toString()){
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

                label ("Subjects: " + uniDashViewModel.getSubjectsCount().toString()){
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
                label ("Diploma Students: " + uniDashViewModel.getDiStudentCount().toString()){
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

                label ("Degree Students: " + uniDashViewModel.getDeStudentCount().toString()){
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

                label ("Academic Staff: " + uniDashViewModel.getAcStaffCount().toString()){
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

                label ("Administrative Staff: " + uniDashViewModel.getAdStaffCount().toString()){
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

                label ("All people: " + uniDashViewModel.getAllPeople().toString()){
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
                                   textfield(search)


                                }
                            }

                            button("Search") {
                                action {
                                    uniDashViewModel.search(search.value.toString())
                                    println("Search")
                                    search.value = ""
                                }
                            }

                        }


                        tableview<Person> {
                            items = listOf(
                                    Person(0,"Jake", 0),
                                    Person(1,"Jake", 1),
                                    Person(2,"Jake", 2),
                                    Person(3,"Jake", 3)
                            ).observable()

                            column("ID",Person::idProperty)
                            column("NAME",Person::name)
                            column("TYPE",Person::type)
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
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
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
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

                borderpane {

                    left = vbox {
                        label ("End of Month Balance"){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        label ("Students will pay R" + uniDashViewModel.getMoneyFees().toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }

                        label ("Staff will be Payed R" + uniDashViewModel.getStaffPayment().toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }
                        var projection =   uniDashViewModel.getMoneyFees() - uniDashViewModel.getStaffPayment()
                        label ("End of Month Projection R" + projection.toString()){
                            style{
                                textFill = Color.rgb(255, 255, 255)
                            }
                        }
                        var poolProjected = uniDashViewModel.getUniPool() - uniDashViewModel.getStaffPayment() - uniDashViewModel.getMoneyFees()
                        label ("Projected Pool Funds R" + poolProjected.toString()){
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
                    style{
                        backgroundColor += Color.rgb(142, 172, 191)
                    }

                }

            }

        }
    }




}