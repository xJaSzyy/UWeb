//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val myPhone: MobilePhone = MobilePhone("+79521654131")

    val contact1 = Contact("Semen", "+79516485794")
    val contact2 = Contact("Vasiliy", "+79999999999")

    //Добавить контакт
    myPhone.addNewContact(contact1)

    //Изменить контакт(из старого в новый)
    val isUpdate: Boolean = myPhone.updateContact(contact1.phoneNumber, contact2.phoneNumber)
    println("\nUpdate:$isUpdate")
    myPhone.printContacts()

    //Удалить контакт
    val isRemove: Boolean = myPhone.removeContact(contact2)
    println("\nRemove:$isRemove")
    myPhone.printContacts()

    //Поиск индекса
    myPhone.addNewContact(contact1)
    myPhone.addNewContact(contact2)
    val index: Int = myPhone.findContact(contact1)
    println("\nIndex:$index")
    myPhone.printContacts()

    //Поиск по имени
    val semenContact: Contact? = myPhone.queryContact("Semen")
    println("\n${semenContact?.name} ${semenContact?.phoneNumber}")
}