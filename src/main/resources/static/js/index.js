processButton=document.getElementById('processButton');
inputArea=document.getElementById('inputArea');
outputArea=document.getElementById('outputArea');
inputMathField=document.getElementById('inputMathField');

inputMathField.menuItems=[
    {
        label:()=>('\\dfrac{d}{dx}'),
        onMenuSelect:()=>
            inputMathField.insert("\\dfrac{d}{dx}\\left(\\placeholder{}\\right)")
    }
]

inputMathField.addEventListener('input',()=>{
    inputArea.value=inputMathField.getValue('latex');
});


processButton.addEventListener('click',()=>{
    const inputText=inputArea.value;
    fetch('/process')
    .then(response=>response.json())
    .then(data=>{
        outputArea.innerHTML=data.result;
    })
    .catch(error=>{
        console.error('Error:',error);
        outputArea.innerHTML='An error occurred while processing your request.';
    });
});