# Order Service

Is responsible to taking care of submitted orders. Every order corresponds to a single tenant and should only be accessible by him. The linked products are submitted with order submit request, in order to guarantee that no price updates made at the shop service changes a submitted order during the order process. It also holds references to discounts and other price related objects at the moment of the submit. Generates order confirmations.
