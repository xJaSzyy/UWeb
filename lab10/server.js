const express = require('express');
const app = express();
const bodyParser = require('body-parser');
const excel = require('exceljs');
const fs = require('fs');

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static('public'));

// Обработчик отправки формы
app.post('/upload', (req, res) => {
    const lastname = req.body.lastname;
    const initial = req.body.initial;
    const password = req.body.password;
    const address = req.body.address;
    const type1 = req.body.type1;
    const type2 = req.body.type2;
    const delivery = req.body.delivery;
    const extra = req.body.extra;
    let invoice = req.body.invoice;
    if (invoice != null) {
        invoice = "Да";
    } else {
        invoice = "Нет";
    }

    const fileName = 'lab10/data.xlsx';
    let workbook;
    if (fs.existsSync(fileName)) {
        workbook = new excel.Workbook();
        workbook.xlsx.readFile(fileName)
            .then(() => {
                const worksheet = workbook.getWorksheet(1);
                worksheet.addRow([lastname, initial, password, address, type1, type2, delivery, invoice, extra]);

                return workbook.xlsx.writeFile(fileName);
            })
            .then(() => {
                res.send('Данные успешно добавлены к существующему файлу Excel.');
            })
            .catch(err => {
                console.error(err);
                res.status(500).send('Произошла ошибка при обновлении файла Excel.');
            });
    } else {
        workbook = new excel.Workbook();
        const worksheet = workbook.addWorksheet('Данные');
        worksheet.addRow(['Фамилия', 'Инициалы', 'Пароль', 'Адрес', 'Тип1', 'Тип2', 'Доставка', 'Требуется накладная', 'Дополнительно']);
        worksheet.addRow([lastname, initial, password, address, type1, type2, delivery, invoice, extra]);

        workbook.xlsx.writeFile(fileName)
            .then(() => {
                res.send('Файл Excel создан и данные успешно добавлены.');
            })
            .catch(err => {
                console.error(err);
                res.status(500).send('Произошла ошибка при создании файла Excel.');
            });
    }
});


app.get('/', (req, res) => {
    res.sendFile(__dirname + '/index.html');
});

const port = 3000;
app.listen(port, () => {
    console.log(`Сервер запущен на порту ${port}`);
});
