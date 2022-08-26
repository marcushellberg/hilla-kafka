import {View} from "Frontend/views/view";
import {customElement, state} from 'lit/decorators.js'
import {html} from "lit";
import {TextFieldChangeEvent} from "@vaadin/text-field";
import '@vaadin/vaadin-messages';
import '@vaadin/vaadin-text-field';
import {MessageEndpoint} from "Frontend/generated/endpoints";
import Message from "Frontend/generated/com/example/application/model/Message";

@customElement('message-view')
export class MessageView extends View {
  @state() messages: Message[] = [];
  @state() userName = '';
  @state() submitting = false;

  get formattedMessages() {
    return this.messages.map((m) => ({
      ...m,
      time: new Date(m.time).toLocaleTimeString('en-US'),
    }));
  }

  render() {
    return html`
      <vaadin-message-list
        class="flex-grow"
        .items=${this.formattedMessages}></vaadin-message-list>
      <div class="flex p-s gap-s items-baseline">
        <vaadin-text-field
          placeholder="Name"
          @change=${this.userNameChange}></vaadin-text-field>
        <vaadin-message-input
          class="flex-grow"
          @submit=${this.submit} ?disabled=${this.submitting}></vaadin-message-input>
      </div>
    `;
  }

  userNameChange(e: TextFieldChangeEvent) {
    this.userName = e.target.value;
  }

  async submit(e: CustomEvent) {
    this.submitting = true;
    await MessageEndpoint.send({
      text: e.detail.value,
      userName: this.userName,
    });
    this.submitting = false;
  }

  connectedCallback() {
    super.connectedCallback();
    this.classList.add('flex', 'flex-col', 'h-full', 'box-border');
    MessageEndpoint.join().onNext(
      (message) => (this.messages = [...this.messages, message])
    );
  }

}