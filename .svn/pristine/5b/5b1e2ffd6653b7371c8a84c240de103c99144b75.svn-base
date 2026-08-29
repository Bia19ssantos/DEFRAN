
//mascara nos campos
$(document).ready(function() {
    $('telefone').mask('(00) 0000-0000');
  });
  
$(document).ready(function() {
    $('celular').mask('(00) 00000-0000');
  });
  
 // MASCARA CNPJ
  document.addEventListener('DOMContentLoaded', function () {
    const inputCnpj = document.querySelector('.input-cnpj');

    // Function to format the CNPJ as the user types
    inputCnpj.addEventListener('input', function () {
      const value = inputCnpj.value.replace(/\D/g, '');

      if (value.length > 2) {
        inputCnpj.value = `${value.slice(0, 2)}.${value.slice(2)}`;
      }

      if (value.length > 5) {
        inputCnpj.value = `${value.slice(0, 2)}.${value.slice(2, 5)}.${value.slice(5)}`;
      }

      if (value.length > 8) {
        inputCnpj.value = `${value.slice(0, 2)}.${value.slice(2, 5)}.${value.slice(5, 8)}/${value.slice(8)}`;
      }

      if (value.length > 12) {
        inputCnpj.value = `${value.slice(0, 2)}.${value.slice(2, 5)}.${value.slice(5, 8)}/${value.slice(8, 12)}-${value.slice(12)}`;
      }
    });
  });
  
  // MASCARA TELEFONE
  
document.addEventListener('DOMContentLoaded', function () {
  // Function to format the phone number as the user types and enforce the 9-character limit
  function formatPhoneNumber(value) {
    const cleanedValue = value.replace(/\D/g, '');

    if (cleanedValue.length > 11) {
      return cleanedValue.slice(0, 11);
    } else if (cleanedValue.length === 11) {
      return `(${cleanedValue.slice(0, 2)}) ${cleanedValue.slice(2, 7)}-${cleanedValue.slice(7)}`;
    } else if (cleanedValue.length === 10) {
      return `(${cleanedValue.slice(0, 2)}) ${cleanedValue.slice(2, 6)}-${cleanedValue.slice(6)}`;
    } else if (cleanedValue.length === 9) {
      return `${cleanedValue.slice(0, 5)}-${cleanedValue.slice(5)}`;
    } else if (cleanedValue.length === 8) {
      return `${cleanedValue.slice(0, 4)}-${cleanedValue.slice(4)}`;
    } else {
      return cleanedValue;
    }
  }

  // Find all phone input fields with the class "input-phone" and apply the phone mask and character limit
  const inputPhones = document.querySelectorAll('.input-phone');

  for (const inputPhone of inputPhones) {
    inputPhone.addEventListener('input', function () {
      inputPhone.value = formatPhoneNumber(inputPhone.value);
    });
  }
});

  
  // MASCARA PARA O CEP

document.addEventListener('DOMContentLoaded', function () {
  // Function to format the CEP as the user types and enforce the 9-character limit
  function formatCEP(value) {
    const cleanedValue = value.replace(/\D/g, '');

    if (cleanedValue.length > 8) {
      return cleanedValue.slice(0, 8);
    } else if (cleanedValue.length > 5) {
      return `${cleanedValue.slice(0, 5)}-${cleanedValue.slice(5)}`;
    } else {
      return cleanedValue;
    }
  }

  // Find all CEP input fields with the class "input-cep" and apply the CEP mask and character limit
  const inputCEPs = document.querySelectorAll('.input-cep');

  for (const inputCEP of inputCEPs) {
    inputCEP.addEventListener('input', function () {
      inputCEP.value = formatCEP(inputCEP.value);
    });
  }
});


// Scripts
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("orcLink").addEventListener("click", function() {
        // Redirecionar para a nova página de orçamentos
        window.location.href = "web/orc.html"; // Substitua "web/orc.html" pelo caminho da sua nova página de orçamentos
    });

    document.getElementById("clientesLink").addEventListener("click", function() {
        // Redirecionar para a página de clientes
        window.location.href = "clientes.html"; // Substitua "clientes.html" pelo caminho correto para a página de clientes
    });
});
window.addEventListener('DOMContentLoaded', event => {

    // Toggle the side navigation
    const sidebarToggle = document.body.querySelector('#sidebarToggle');
    if (sidebarToggle) {
        // Uncomment Below to persist sidebar toggle between refreshes
        // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
        //     document.body.classList.toggle('sb-sidenav-toggled');
        // }
        sidebarToggle.addEventListener('click', event => {
            event.preventDefault();
            document.body.classList.toggle('sb-sidenav-toggled');
            localStorage.setItem('sb|sidebar-toggle', document.body.classList.contains('sb-sidenav-toggled'));
        });
    }

});