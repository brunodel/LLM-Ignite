import axios from 'axios';

export const callMessageChat = async (userMessage, setMessages, animal) => {
    // debugger
    try {
        const response = await axios.post('http://localhost:8080/v1/llm/chat', {
            userChatMessage: userMessage,
            animal: animal
        });

        // const data = await response.json();
        // debugger
        const data = response.data.choices[0].message.content;

        // Adiciona a resposta do servidor na lista de mensagens
        const serverMessage = { text: `${data || 'Mensagem recebida!'}`, sender: 'server' };
        setMessages((prevMessages) => [...prevMessages, serverMessage]);
    } catch (error) {
        // Mensagem de erro caso a chamada falhe
        const errorMessage = { text: 'Erro ao se comunicar com o servidor.', sender: 'server' };
        setMessages((prevMessages) => [...prevMessages, errorMessage]);
    }
} 

export const makeInitialCall = async () => {
    // debugger
    try {
        const response = await axios.get('http://localhost:8080/v1/llm/initial-call');

        // const data = await response.json();
        // debugger
        //const data = response.data.choices[0].message.content;
        const data = response.data;

        return data;

    } catch (error) {
        console.log(error);
    }
}