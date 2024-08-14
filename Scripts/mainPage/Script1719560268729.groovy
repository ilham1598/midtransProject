import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL as GLOBAL
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.urlMain)

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/orderMidtrans/btnBuyNow'))

WebUI.verifyElementPresent(findTestObject('Object Repository/orderMidtrans/verifyShoppingCart'), 1)

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputPillow'), GlobalVariable.amount)

WebUI.verifyElementText(findTestObject('Object Repository/orderMidtrans/verifyTotalAmount'), '50,000')

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputName'), GlobalVariable.name)

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputEmail'), GlobalVariable.email)

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputPhone'), GlobalVariable.phoneNo)

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputCity'), GlobalVariable.city)

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputAddress'), GlobalVariable.address)

WebUI.setText(findTestObject('Object Repository/orderMidtrans/inputPostalCode'), GlobalVariable.postalCode)

WebUI.click(findTestObject('Object Repository/orderMidtrans/btnCheckout'))

WebUI.switchToFrame(findTestObject('Object Repository/orderMidtrans/popUpPayment'), 3)

WebUI.click(findTestObject('Object Repository/orderMidtrans/paymentVA'))

WebUI.click(findTestObject('Object Repository/orderMidtrans/paymentVABCA'))

GlobalVariable.vaNumber = WebUI.getText(findTestObject('Object Repository/orderMidtrans/getVAnumber'))

WebUI.comment(GlobalVariable.vaNumber)

WebUI.executeJavaScript('window.open();', [])

WebUI.callTestCase(findTestCase('sandboxMidtrans'), [:])

WebUI.switchToWindowIndex(0)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/orderMidtrans/btnCheckStatus'))

