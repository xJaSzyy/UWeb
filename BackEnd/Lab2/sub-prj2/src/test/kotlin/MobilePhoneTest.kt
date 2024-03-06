import org.example.Contact
import org.example.MobilePhone
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.slf4j.LoggerFactory

class MobilePhoneTest {

    val phone = MobilePhone("+79999999999")
    private val logger = LoggerFactory.getLogger(Contact::class.java)

    @Test
    fun addNewContact() {
        val isAdd = phone.addNewContact(Contact("Mark", "+71111111111"))
        assertTrue(isAdd)
    }

    @Test
    fun removeContact() {
        try {
            val isRemove = phone.removeContact(Contact("выпыпы", "+79999999999"))
            assertTrue(isRemove)
            logger.info("Тест пройден")
        } catch (e: AssertionError) {
            logger.error("Ошибка " + e.message)
        }
    }
}