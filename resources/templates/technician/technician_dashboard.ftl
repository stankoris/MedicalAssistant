<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Technician dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css" integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="/technician_dashboard.css">


<#--  -----------------------------------------------------------------------------------------------------------------------  -->



    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/flatpickr/dist/flatpickr.min.css">
    <link rel="stylesheet" type="text/css" href="https://npmcdn.com/flatpickr/dist/themes/dark.css">



  <#--  -----------------------------------------------------------------------------------------------------------------------  -->
</head>
<body>

  <aside>
    <h1><a href="/technician">MedicalAssistant</a></h1>
    <div id="calendar"></div>
  </aside>

  <main>
     <header>
    <div class="container">
      <button id="showOptionsBtn" ><i class="fa-solid fa-bars"></i></button>
        <div class="options-container" id="optionsContainer">
            <a href="/technician/all_patients">All patients</a>
            <a href="/technician/find_patients">Find patient</a>
            <a href="/technician/new_patient">New patient</a>
        </div>
    </div>
  </header>
  
  <div  class="main_div">

    <div class="main_aside">
      <table>
        <tr>
          <td></td>
        </tr>
        <tr>
          <td>07:00</td>
        </tr>
        <tr>
          <td>08:00</td>
        </tr>
        <tr>
          <td>09:00</td>
        </tr>
        <tr>
          <td>10:00</td>
        </tr>
        <tr>
          <td>11:00</td>
        </tr>
        <tr>
          <td>12:00</td>
        </tr>
        <tr>
          <td>13:00</td>
        </tr>
        <tr>
          <td>14:00</td>
        </tr>
        <tr>
          <td>15:00</td>
        </tr>
        <tr>
          <td>16:00</td>
        </tr>
        <tr>
          <td>17:00</td>
        </tr>
        <tr>
          <td>18:00</td>
        </tr>
        <tr>
          <td>19:00</td>
        </tr>
        <tr>
          <td>20:00</td>
        </tr>
      </table>
    </div>

    <div class="main_div_container">
       <table>
        <tr>
          <td>
            <#list doctors as doctor>
              ${doctor.full_name()}
            </#list>
          </td>
        </tr>
        <tr>
          <td>07:00</td>
        </tr>
        <tr>
          <td>08:00</td>
        </tr>
        <tr>
          <td>09:00</td>
        </tr>
        <tr>
          <td>10:00</td>
        </tr>
        <tr>
          <td>11:00</td>
        </tr>
        <tr>
          <td>12:00</td>
        </tr>
        <tr>
          <td>13:00</td>
        </tr>
        <tr>
          <td>14:00</td>
        </tr>
        <tr>
          <td>15:00</td>
        </tr>
        <tr>
          <td>16:00</td>
        </tr>
        <tr>
          <td>17:00</td>
        </tr>
        <tr>
          <td>18:00</td>
        </tr>
        <tr>
          <td>19:00</td>
        </tr>
        <tr>
          <td>20:00</td>
        </tr>
      </table>
    </div>
  </div>



  </main>

  <script src="https://cdn.jsdelivr.net/npm/flatpickr"></script>
  <script>

    //Kalendar
    flatpickr("#calendar", {
            mode: "single",
            inline: true, 
            dateFormat: "Y-m-d", 
            
        });
    //Kalendar

        document.getElementById('showOptionsBtn').addEventListener('click', function() {
      var optionsContainer = document.getElementById('optionsContainer');

      if (optionsContainer.classList.contains('show')) {
        optionsContainer.classList.remove('show');
      } else {
        optionsContainer.classList.add('show');
      }
    });


  </script>
</body>
</html>

